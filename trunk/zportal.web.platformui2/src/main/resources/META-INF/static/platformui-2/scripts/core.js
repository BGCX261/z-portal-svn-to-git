var PlatformUI = {
};

(function (ns) {
    
    ns.version = '2.0.0-beta';


    ns.body = function () {
        return document.body;
    };

    ns.element = function (arg) {
        if (typeof arg !== 'undefined') {
            if (typeof arg === 'string') {
                if (arg.length > 0) {
                    if (arg[0] !== '#')
                        return document.getElementById(arg);
                    else
                        return document.getElementById(arg.substring(1));
                }
            }

            else if (arg instanceof jQuery && arg.length > 0)
                return arg[0];

            else if (typeof arg.tagName !== 'undefined')
                return arg;

            else if (typeof arg.getElement !== 'undefined')
                return arg.getElement();
        }    

        throw 'Invalid argument';
    };

    ns.ns = function (path) {
        var tokens = path.split('.');
        var i;
        var obj = window;
        for (i = 0; i < tokens.length; ++i) {
            if (!obj[tokens[i]]) {
                obj[tokens[i]] = {};
            }

            obj = obj[tokens[i]];
        }
        
        return obj;
    };

    ns.inherit = function (parent, child) {
        var construct = function () {};
        construct.prototype = parent.prototype;
        child.prototype = new construct();
        child.prototype.constructor = child;
        child.super = parent;
    };

    ns.value = function (item, path) {
        var tokens = path.split('.');
        var i;
        for (i = 0; i < tokens.length; ++i) {
            item = item[tokens[i]];
        }

        return item;
    };
    
} (PlatformUI));