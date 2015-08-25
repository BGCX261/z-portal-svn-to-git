(function (ns) {
    ns.DataSource = function (readUrl) {
        ns.DataSource.super.call(this, readUrl, PlatformUI.RequestFormat.Json);
    };
    
    ns.DataSource.prototype = {
        prepareData: function (data) {
            return data.data;
        }
    };
    
    PlatformUI.inherit(PlatformUI.RemoteDataSource, ns.DataSource);
    
} (PlatformUI.ns('ZP')));
