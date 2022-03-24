let PlayerController = require("../controllers/Player.controller");

module.exports = function(app) {
    app.get("/api/players", PlayerController.getAllAuthors)

    // app.get("/api/players/:id", PlayerController.getOneAuthor)
    
    app.post("/api/players/new", PlayerController.createAuthor)
    
    // app.put("/api/players/:id", PlayerController.updateAuthor)
    
    app.delete("/api/players/:id", PlayerController.deleteAuthor)
}