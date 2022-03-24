let Product = require("../models/Product.model");

module.exports.getAllProducts = function (req, res) {
    Product.find()
    .then(products=>res.json(products))
    .catch(err=>console.log(err))
}

module.exports.getOneProduct = function (req, res) {
    Product.find({_id: req.params.id})
    .then(product=>res.json(product))
    .catch(err=>console.log(err))
}

module.exports.createProduct = function (req, res) {
    Product.create(req.body)
    .then(newProduct=>res.json(newProduct))
    .catch(err=>console.log(err))
}

module.exports.updateProduct = function (req, res) {
    Product.findOneAndUpdate({ _id: req.params.id }, req.body, {new:true})
    .then(updatedProduct=> res.json(updatedProduct))
    .catch(err=> console.log(err))
}

module.exports.deleteProduct = function (req, res) {
    Product.deleteOne({ _id: req.params.id })
    .then(result=>res.json(result))
    .catch(err=>console.log(err))
}