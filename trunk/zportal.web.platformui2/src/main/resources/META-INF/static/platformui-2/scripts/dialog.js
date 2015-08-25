(function (ns) {

    ns.Dialog = function (content) {
        if (content)
            this._content = $(ns.element(content));
        else
            this._content = $('<div></div>');

        this._wrapper = null;
        this._dialog = null;
        this._title = null;
        this._container = null;
        this._commandPanel = null;
        this._init();
    };

    ns.Dialog.prototype = {
        _init: function () {        
            var _this = this;

            // Background.
            var bg = $('<div class="Background"></div>');

            // Dialog.
            var dialog = $('<div class="Dialog"></div>');

            var title = $('<h1></h1>');
            dialog.append(title);

            var container = $('<div class="Container"></div>');
            container.append(this._content);
            dialog.append(container);

            var commandPanel = $('<div class="CommandPanel"></div>');
            commandPanel.hide();
            dialog.append(commandPanel);

            // Wrapper.
            var wrapper = $('<div class="PlatformUI-Control PlatformUI-Dialog"></div>');
            wrapper.hide();
            wrapper.append(bg);
            wrapper.append(dialog);

            // Final initializations.
            $(ns.body()).append(wrapper);
            _this._title = title;
            _this._container = container;
            _this._commandPanel = commandPanel;
            _this._dialog = dialog;
            _this._wrapper = wrapper;
        },

        setContentElement: function (elem) {
            var _this = this;

            _this._container.empty();
            _this._container.append(ns.element(elem));
        },

        getContentElement: function () {
            var _this = this;

            return _this._content;
        },

        setTitle: function (title) {
            var _this = this;

            _this._title.text(title);
        },

        getTitle: function () {
            var _this = this;

            return _this._title.text();
        },

        addCommandElement: function (elem) {
            var _this = this;

            _this._commandPanel.append(ns.element(elem));
            _this._commandPanel.show();
        },

        show: function () {
            var _this = this;

            _this._wrapper.css('z-index', ns.nextZIndex());

            var dialog = _this._dialog;

            ns.appear(_this._wrapper, {
                start: function () {
                    var width = dialog.width();
                    var height = dialog.height();
                    dialog.css({
                        'margin-left': -Math.round(width / 2),
                        'margin-top': -Math.round(height / 2)
                    });                
                }
            });
        },

        hide: function () {
            var _this = this;

            ns.disappear(_this._wrapper);
        }
    };
    
} (PlatformUI));