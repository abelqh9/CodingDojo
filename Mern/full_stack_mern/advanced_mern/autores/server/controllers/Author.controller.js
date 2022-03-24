let Author = require("../models/Author.model");

module.exports.getAllAuthors = function (req, res) {
    Author.find()
    .then(products=>res.json(products))
    .catch(err=>console.log(err))
}

module.exports.getOneAuthor = function (req, res) {
    console.log(32323);
    Author.find({_id: req.params.id})
    .then(product=>res.json(product))
    .catch(err=>res.status(400).json(err))
}

module.exports.createAuthor = function (req, res) {
    Author.create(req.body)
    .then(newProduct=>res.json(newProduct))
    .catch(err=>res.status(400).json(err))
}

module.exports.updateAuthor = function (req, res) {
    Author.findOneAndUpdate({ _id: req.params.id }, req.body, { new: true, runValidators: true})
    .then(updatedProduct=> res.json(updatedProduct))
    .catch(err=>res.status(400).json(err))
}

module.exports.deleteAuthor = function (req, res) {
    Author.deleteOne({ _id: req.params.id })
    .then(result=>res.json(result))
    .catch(err=>console.log(err))
}