let Product = require("../models/Product.model");

module.exports.createProduct = function (req, res) {
    Product.create(req.body)
    .then(newProduct=>res.json(newProduct))
    .catch(err=>console.log(err))
}