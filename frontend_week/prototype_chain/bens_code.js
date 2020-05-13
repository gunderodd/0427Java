// Assignment: Make a prototypical chain
function baseClass(){
    this.a = 1;
    // in this function/class there is a hidden property called prototype (this.prototype)
    // prototype points to the Prototype object, which points back to this constructor.
}
// When this constructor is called, the instance is created with the constructor above
// Also, the __proto__ property is created
let base = new baseClass();
// This __proto__ property points to the prototype object for baseClass, which points to the constructor
console.log(base);
base.b = "This is b. I was just added to the base class instance.";
console.log(base);
// thing.prototype points to the constructor for the baseClass (rather than for its own class)
let prototype = baseClass.prototype;
console.log(baseClass.prototype === base.__proto__);//true
let anotherBase = new baseClass();
console.log(anotherBase.__proto__===anotherBase.__proto__)
// thimg.prototype will always point to the constructor, but we can add our own properties to it as well!
prototype.name = "Prototype";
prototype.greeting = "Hello. I am the prototype for the baseClass. It's nice to meet you";
prototype.sit = function sit(chair) {console.log("I am sigging on "+chair);};
// now if I print out the classes that point to prototype, they've updated as well since they point to the same thing
console.log(base);
console.log(anotherBase);
// Therefore, base and anotherBase have de-facto inherited name and greeting from the baseClass prototype! Moreover, any property from the baseClass prototype
// not overwritten by the instance has the prototype's values and can be accessed accordingly
console.log(base.name);
console.log(anotherBase.name);
console.log(base.greeting);
console.log(anotherBase.greeting);
console.log("Whoa, I didn't set the names and greetings above, my prototype did!")
base.name = "Newer Model";
console.log(`Calling yourself prototype is so no longer fashionable. This base instance calls itself \"${base.name}\"`)
function baseBaby(){
    this.b=2;
}
// Now lets have the instance of baseBaby named baby inherit from base
// If we want baby to inherit from base, we have to assign baseBaby's prototype property to point to base, which also points to baseClass.prototype
baseBaby.prototype = base;
let baby = new baseBaby();
console.log(baby);
console.log("From the baseBaby prototype: "+baby.name);
console.log("From the baseBaby prototype: "+baby.a);
console.log("From the baseBaby constructor: "+baby.b);
console.log("From the baseBaby prototype: "+baby.greeting);
baby.name = "N3w35t M0d3l";
console.log(`PSSSSHHHHHH, that old name is so lame. This baseBaby calls itself ${baby.name} now!`);
baby.greeting = "\'Sup losers! That\'s my new greeting now! *baby is going through a phase*";
console.log(baby.greeting);
console.log(baby.a, baby.b);

