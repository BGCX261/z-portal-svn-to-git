(function (ns) {

    ns.ConfirmDialog = function () {	
        this._title = null;
        this._text = null;
        this._yesButton = null;
        this._cancelButtonText = null;

        this._dialog = null;
        this._events = {
                confirm: [],
                cancel: []
        };

        this._init();
    };	

    ns.ConfirmDialog.prototype = {
        _init: function () {
            var _this = this;

            var text = $('<div></div>');

            var yesButton = new ns.Button();
            yesButton.setText('ОК');
            yesButton.onClick(function () {
                _this._onConfirm();
            });

            var noButton = new ns.Button();
            noButton.setText('Отмена');
            noButton.onClick(function () {
                _this._onCancel();
            });

            var dialog = new ns.Dialog();
            dialog.setContentElement(text);
            dialog.addCommandElement(yesButton);
            dialog.addCommandElement(noButton);

            this._dialog = dialog;
            this._text = text;
            this._yesButton = yesButton;
            this._noButton = noButton;
        },

        _onConfirm: function () {
            var i;
            for (i = 0; i < this._events.confirm.length; ++i)
                    this._events.confirm[i]();
        },

        _onCancel: function () {
            this._dialog.hide();

            var i;
            for (i = 0; i < this._events.cancel.length; ++i) {
                    this._events.cancel[i]();
            }
        },

        setTitle: function (title) {
            this._dialog.setTitle(title);
        },

        getTitle: function () {
            return this._dialog.getTitle();
        },

        setText: function (text) {
            this._text.text(text);
        },

        getText: function () {
            return this._text.text();
        },

        setYesButtonText: function (text) {
            this._yesButton.setText(text);
        },

        getYesButtonText: function () {
            return this._yesButton.getText();
        },

        setNoButtonText: function (text) {
            this._noButton.setText(text);
        },

        getNoButtonText: function () {
            return this._noButton.getText();
        },

        onConfirm: function (handler) {
                this._events.confirm.push(handler);
        },

        onCancel: function (handler) {
                this._events.cancel.push(handler);
        },

        show: function () {
                this._dialog.show();
        },

        hide: function () {
                this._dialog.hide();
        }
    };

} (PlatformUI));