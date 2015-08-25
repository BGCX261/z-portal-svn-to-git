(function (ns) {
    
    ns.R = {
        menuTemplate: '<div class="shell-menu"></div>',
        menuItemTemplate: '<a href="javascript: void(0)"></a>',
        containerTemplate: '<div class="shell-container"></div>'
    };
    
    ns._menuEl = null;
    ns._containerEl = null;
    ns._rootComponents = {};
    ns._currentRootComponent = null;
        
    ns._initMenu = function () {
        var body = $(PlatformUI.body());
        var menuEl = $(ns.R.menuTemplate);
        var containerEl = $(ns.R.containerTemplate);
        
        body.append(menuEl);
        body.append(containerEl);
        ns._menuEl = menuEl;
        ns._containerEl = containerEl;
        
        ns.remote(
            ns.url('/shell/listMenuItems'),
            { containerName: ns.containerName },
            function (resp) {
                resp.forEach(function (it) {
                    var itemEl = $(ns.R.menuItemTemplate);
                    itemEl.text(it.title);
                    itemEl.click(function () {
                       ns.loadModule(it.module);
                    });
                    
                    menuEl.append(itemEl);
                });
            });
    };
    
    ns.init = function (rootUrl, containerName) {       
        ns.rootUrl = rootUrl;
        ns.containerName = containerName;
        
        require.config({
            baseUrl: ns.url('/static')
        });
        
        ns._initMenu();
    };
    
    ns.url = function (relative) {
        return ns.rootUrl + relative;
    };
    
    ns.remote = function (url, data, callback, scope) {
        PlatformUI
            .remoteJSON(url, data)
            .done(function (resp) {
                if (resp.success) {
                    if (callback) {
                        callback.call(scope || this, resp.data);
                    }
                }
                else {
                    alert(resp.message);
                }
            });        
    };
   
    ns.loadModule = function (moduleName) {
        if (!ns._rootComponents[moduleName]) {        
            require(
                [ moduleName ],
                function (module) {
                    var rootComponent = module.getRootComponent();
                    rootComponent.hide();
                    
                    ns._rootComponents[moduleName] = rootComponent;
                    ns._containerEl.append(rootComponent);
                    
                    ns._displayRootComponent(rootComponent);
                },
                function (error) {
                    alert(error);
                });
        }
        else {
            ns._displayRootComponent(ns._rootComponents[moduleName]);
        }
    };
    
    ns._displayRootComponent = function (rootComponent) {
        if (ns._currentRootComponent) {
            ns._currentRootComponent.hide();
        }
        
        rootComponent.show();
        ns._currentRootComponent = rootComponent;
    };
   
} (PlatformUI.ns('ZP.Shell')));