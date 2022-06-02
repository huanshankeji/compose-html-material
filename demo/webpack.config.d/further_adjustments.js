// for both webpack.config.js and karma.conf.js

const extraEntry = {
    'webcomponents-loader': '@webcomponents/webcomponentsjs/webcomponents-loader.js',
};

config.entry = config.entry != null ? Object.assign(config.entry, extraEntry) : extraEntry;

if (config.output != null) {
    const kotlinJsFilename = config.output.filename;
    config.output.filename = chunkData =>
        chunkData.chunk.name in extraEntry ? "[name].js" : kotlinJsFilename(chunkData);
}
else
    config.output = { filename: "[name].js" };

// see: https://github.com/material-components/material-components-web/blob/master/docs/getting-started.md

const mainEntryExtras = ['./kotlin/app.scss',];
if (config.entry.main != null)
    config.entry.main.push(...mainEntryExtras);
else
    config.entry.main = mainEntryExtras;

config.module.rules.push({
    test: /\.scss$/,
    use: [
        {
            loader: 'file-loader',
            options: {
                name: 'app.css',
            },
        },
        { loader: 'extract-loader' },
        { loader: 'css-loader' },
        { loader: 'sass-loader' },
    ],
});
