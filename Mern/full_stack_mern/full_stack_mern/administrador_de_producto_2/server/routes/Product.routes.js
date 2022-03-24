let ProductController = require("../controllers/Product.controller");

module.exports = function(app) {
    app.get("/api/products", ProductController.getAllProducts)
    app.get("/api/products/:id", ProductController.getOneProduct)
    app.post("/api/products/new", ProductController.createProduct)
}