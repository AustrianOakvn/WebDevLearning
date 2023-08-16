const countries = [
  "Albania",
  "Bolivia",
  "Canada",
  "Denmark",
  "Ethiopia",
  "Finland",
  "Germany",
  "Hungary",
  "Ireland",
  "Japan",
  "Kenya",
];
let text =
  "I love teaching and empowering people. I teach HTML, CSS, JS, React, Python.";
// const means that the array can not be reassigned
const shoppingCart = ["Milk", "Coffee", "Tea", "Honey"];

text = text.trim();
let words = text.split(" ");

// add meat in the beginning
shoppingCart.unshift("Meat");
// add sugar at the end
shoppingCart.push("Sugar");
//remove honey
shoppingCart.pop();
// modify tea to green tea
teaIndex = shoppingCart.indexOf("Tea");
shoppingCart[teaIndex] = "Green Tea";

// const jsxElement = <h1>I am a JSX element</h1>;
// const welcome = <h1>Welcome to 30 Days of React Challenge</h1>;
// const data = <small>Oct 2, 2020</small>;

console.log(words);
console.log(words.length);
console.log(shoppingCart);
