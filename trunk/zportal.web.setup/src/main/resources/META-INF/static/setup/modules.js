define([], function () {
    var ns = PlatformUI.ns('ZP.Setup.Modules');
    
    (function (ns) {
        ns.getRootComponent = function () {
            var root = $('<div><h1>Модули</h1><table data-control-id="modules-grid" style="width: 100%"></table></div>');
            
            var gridEl = $('[data-control-id=\'modules-grid\']', root);
            
            var options = {
                columns: [
                    { dataColumn: { name: 'name' }, header: 'Название модуля', width: '50%' },
                    { dataColumn: { name: 'moduleId' }, header: 'ID модуля', width: '50%' }
                ],
                emptyDataText: 'Не найдено модулей'
            };
            
            var dataSource = new ZP.DataSource(ZP.Shell.url('/setup/modules'));
            
            var grid = new PlatformUI.Grid(options, dataSource, gridEl);
            grid.dataBind();
            
            return root;
        };
    } (ns));
    
    return ns;
});
