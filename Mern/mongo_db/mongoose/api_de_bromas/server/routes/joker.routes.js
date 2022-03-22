let JokeController = require("../controllers/joker.controller");

module.exports = function(app) {
    app.get("/api/jokes", JokeController.findAllJokes);
    app.get("/api/jokes/random", JokeController.findRandomJoke);
    app.get("/api/jokes/:id", JokeController.findJoke);
    app.post("/api/jokes/new", JokeController.createJoke);
    app.put("/api/jokes/update/:id", JokeController.updateJoke);
    app.delete("/api/jokes/delete/:id", JokeController.deleteJoke);
}