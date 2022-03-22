let Joke = require("../models/joker.model");

module.exports.findAllJokes = function (req, res) {
    Joke.find()
    .then(allJokes => res.json({ jokes: allJokes }))
    .catch(err => res.json({ message: "Something went wrong", error: err }));
}

module.exports.findJoke = function (req, res) {
    Joke.findOne({ _id: req.params.id })
    .then(joke => res.json({ joke: joke }))
    .catch(err => res.json({ message: "Something went wrong", error: err }));
}

module.exports.findRandomJoke = function (req, res) {
    Joke.countDocuments()
    .then(count => {
        let random = Math.floor(Math.random() * count);
        return Joke.findOne().skip(random);
    })
    .then(result => res.json(result))
    .catch(err => res.json({ message: "Something went wrong", error: err }));
}

module.exports.createJoke = function(req, res) {
    console.log(req.body);
    Joke.create( req.body )
    .then(newJoke => res.json({ joke: newJoke }))
    .catch(err => res.json({ message: "Something went wrong", error: err }));
}

module.exports.updateJoke = function(req, res) {
    Joke.updateOne({ _id: req.params.id }, req.body, { new: true })
    .then(updateJoke => res.json({ joke: updateJoke }))
    .catch(err => res.json({ message: "Something went wrong", error: err }));
}

module.exports.deleteJoke = function(req, res) {
    Joke.deleteOne({ _id: req.params.id })
    .then(result => res.json({ result }))
    .catch(err => res.json({ message: "Something went wrong", error: err }));
}