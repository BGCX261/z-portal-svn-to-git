#!/bin/bash

cat \
    content/core.css \
    content/button.css \
    content/calendar.css \
    content/datetimepicker.css \
    content/dialog.css \
    content/dropdown.css \
    content/grid.css \
    content/itemslist.css \
    content/pager.css \
    content/tabs.css \
    content/validation.css \
    content/waitarea.css > combined.css

java -jar yuicompressor-2.4.8.jar --type css -o platformui.2.0.min.css combined.css

uglifyjs \
    scripts/core.js \
    scripts/utils.js \
    scripts/locale.js \
    scripts/remote.js \
    scripts/datasource.js \
    scripts/forms.js \
    scripts/validation.js \
    scripts/waitarea.js \
    scripts/button.js \
    scripts/calendar.js \
    scripts/confirmdialog.js \
    scripts/messagedialog.js \
    scripts/datetimepicker.js \
    scripts/dialog.js \
    scripts/dropdown.js \
    scripts/grid.js \
    scripts/itemslist.js \
    scripts/pager.js \
    scripts/tabs.js \
    \
    -o platformui.2.0.min.js \
    --source-map platformui.2.0.min.js.map \
    -c -m
