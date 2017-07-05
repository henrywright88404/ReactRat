var webpack = require('webpack');
const ExtractTextPlugin = require('extract-text-webpack-plugin');

module.exports = {
  context: __dirname,
  entry: "./src/index.js",
  module: {
    loaders: [
      {
        test: /\.js|.jsx?$/,
        exclude: /(node_modules|bower_components)/,
        loader: 'babel-loader',
        query: {
          presets: ['react', 'es2015', 'stage-0'],
          plugins: ['react-html-attrs', 'transform-class-properties',
                     'transform-decorators-legacy']
        }
      },
      {
        test: /\.scss$/,
        loader: ExtractTextPlugin.extract('css-loader!sass-loader')
      }
    ]
  },
  output: {
    path: __dirname,
    filename: "bundle.js"
  },
  plugins: [
    new ExtractTextPlugin({filename:'src/assets/stylesheets/app.css', allChunks: true} )
  ],
  devServer: {
    historyApiFallback: true
}
};
