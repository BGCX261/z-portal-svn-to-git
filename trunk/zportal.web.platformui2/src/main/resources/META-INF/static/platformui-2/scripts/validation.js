(function (ns) {

    ns.RequiredValidator = function () {
    };

    ns.RequiredValidator.prototype = {
        validate: function(value) {
            if (!value)
                return false;

            return true;
        }
    };


    ns.IntegerFormatValidator = function () {
    };

    ns.IntegerFormatValidator.prototype = {
        validate: function (value) {
            var i;
            for (i = 0; i < value.length; ++i) {
                if (value[i] < '0' || value[i] > '9')
                    return false;
            }

            return true;
        }
    };


    ns.FloatFormatValidator = function () {
    };

    ns.FloatFormatValidator.prototype = {
        validate: function (value) {
            if (!value) return true;

            var floatValue = parseFloat(value);
            return !isNaN(floatValue);
        }
    };


    ns.EmailFormatValidator = function () {
    };

    ns.EmailFormatValidator.prototype = {
        validate: function (value) {
            return /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(value);
        }
    };


    ns.FormValidator = function(form) {
        this._form = ns.element(form);
        this._container = null;
        this._fieldRules = {};
        this._validatorsVisible = false;
        this._enabled = true;

        this._initValidators();
    };

    ns.FormValidator.prototype = {

        _initValidators: function () {
            this._container = $('<div></div>');
            this._container.addClass('ns-Control ns-Validator-Container');

            $(ns.body()).append(this._container);

            var _this = this;
            ns.body().addEventListener('click', function () { _this._body_OnClick(); }, true);
        },

        _showValidator: function (validator, input, message) {
            validator.text(message);


            var inputOffset = input.offset(),
                x = input.width() + inputOffset.left,
                y = inputOffset.top;

            validator.css({
                'z-index': ns.nextZIndex(),
                'left': x,
                'top': y,
                'position': 'absolute'
            });
            ns.appear(validator);

            this._validatorsVisible = true;
        },

        _validateFieldRule: function (validator, input, rule, show) {
            if (rule.validator.validate(ns.getInputValue(input)))
                return true;

            if (show) {
                this._showValidator(validator, $(input), rule.message);
            }

            return false;
        },

        _body_OnClick: function () {
            if (!this._validatorsVisible)
                return;

            var field,
                fieldRule;
            for (field in this._fieldRules) {
                fieldRule = this._fieldRules[field];

                if (fieldRule.validator.is(':visible'))
                    ns.disappear(fieldRule.validator);
            }

            this._validatorsVisible = false;
        },

        addFieldRule: function (field, rule) {

            var newRule = {
                validator: rule.validator,
                message: rule.message,
                enabled: true
            };

            if (!this._fieldRules[field]) {
                var input = this._form[field];

                var validator = $('<div></div>');
                validator.addClass('PltformUI-Control ns-FieldValidator');
                validator.hide();

                this._container.append(validator);

                this._fieldRules[field] = { validator: validator, input: input, rules: [ newRule ] };
            }
            else
                this._fieldRules[field].rules.push(newRule);
        },

        showMessage: function (field, message) {
            var fieldRule = this._fieldRules[field];
            this._showValidator(fieldRule.validator, fieldRule.input, message);
        },

        enableFieldRules: function (field, enabled) {
            var i,
                fieldRule = this._fieldRules[field];
            for (i = 0; i < fieldRule.rules.length; ++i)
                fieldRule.rules[i].enabled = enabled;
        },

        setEnabled: function (enabled) {
            this._enabled = enabled;
        },

        _validate: function (show) {
            if (!this._enabled)
                return true;


            var field,
                fieldRule,
                i,
                validated,
                isValid = true;

            for (field in this._fieldRules) {
                fieldRule = this._fieldRules[field];
                validated = true;

                for (i = 0; i < fieldRule.rules.length; ++i) {
                    if (!fieldRule.rules[i].enabled)
                        continue;

                    validated = this._validateFieldRule(
                        fieldRule.validator,
                        fieldRule.input,
                        fieldRule.rules[i],
                        show
                    );

                    if (!validated)
                        break;
                }

                if (!validated)
                    isValid = false;
            }

            return isValid;
        },

        validate: function () {
            return this._validate(true);
        },

        isValid: function () {
            return this._validate(false);
        }
    };

} (PlatformUI));
