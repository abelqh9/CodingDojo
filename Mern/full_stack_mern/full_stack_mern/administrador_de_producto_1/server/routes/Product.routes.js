let ProductController = require("../controllers/Product.controller");

module.exports = function(app) {
    app.post("/products/new", ProductController.createProduct)
}