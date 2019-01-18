var path = require('path')

module.exports = {
    entry: './index',
    output: {
        filename: 'bundle.js',
        path: path.resolve('./dist'),
        publicPath: '/'
    },
    resolve: {
        extensions: ['', '.js', '.jsx']
    },
    module: {
        loaders: [
            { test: /\.(js|jsx)$/, loader: 'babel-loader', exclude: /node_modules/ },
            { test: /\.css$/, loader: 'style-loader!css-loader' },
            { test: /\.sass/, loader: 'style-loader!css-loader!sass-loader?outputStyle=expanded&indentedSyntax' },
            { test: /\.scss/, loader: 'style-loader!css-loader!sass-loader?outputStyle=expanded' },
            { test: /\.less/, loader: 'style-loader!css-loader!less-loader' },
            { test: /\.(png|jpg|gif|woff|woff2)$/, loader: 'url-loader?limit=8192' },
            { test: /\.eot(\?v=\d+\.\d+\.\d+)?$/, loader: 'file-loader' },
            { test: /\.ttf(\?v=\d+\.\d+\.\d+)?$/, loader: 'url-loader?limit=10000&mimetype=application/octet-stream' },
            { test: /\.svg(\?v=\d+\.\d+\.\d+)?$/, loader: 'url-loader?limit=10000&mimetype=image/svg+xml' }
        ]
    },
    mode: 'development',
    devtool: 'source-map'
}
