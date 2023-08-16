# Day 1 - Javascript refresher note

## Method to include Javascript code

- Inline script
- Internal script
- External script

## Variables

- Use `var`, `let` and `const` to declare variable
- `var` is functions scope
- `let` and `const` are block scope

```javascript
let firstName = "Bui";
```

## Data types

### Primitives

#### Numbers (int, float)

#### Strings

- Data inside single quote, double quote, back tick

```javascript
let firstName = "Asabeneh";
let lastName = "Yetayeh";
// String concat
let fullName = firstName + space + lastName; // concatenation, merging two string together.
console.log(fullName);
// Asebened Yetayeh
```

- Template literals
  Inside the `{}` is an expression

```javascript
console.log(`The sum of 2 and 3 is 5`); // statically writing the data
let a = 2;
let b = 3;
console.log(`The sum of ${a} and ${b} is ${a + b}`);
```

- String methods
  - length `firstName.length`
  - Access character by index `string[0]`
  - `toUpperCase()`
  - `toLowerCase()`
  - `substr()` slice string
  - `substring()` same as above but doesn't include char at the stopping index.
  - `split()`
  - `trim()`
  - `includes()` check if substring exists
  - `replace()`
  - `charAt()`
  - `charCodeAt()` return char code ASCII
  - `indexOf()`
  - `lastIndexOf()` last position of substring

#### Booleans (true, false)

#### Null (empty)

#### Undefined

#### Symbol

### Non-primitive (object, array)

- Non primitive data types are mutable

#### Array

- Array is a list of data values in square bracket. It could contains different data type.

```javascript
// Array constructor
const arr = Array();
// empty array
const arr = [];
let nums = [1, 2, 3];
console.log(nums[0]);

// Object
let userOne = {
  name: "Asabeneh",
  role: "teaching",
  country: "Finland",
};
```

- Elements in array can be accessed by index and index starts from 0

### Math objects

- Can be access by Math lib

```javascript
const PI = Math.PI;

console.log(PI); // 3.141592653589793

// Rounding to the closest number
// if above .5 up if less 0.5 down rounding

console.log(Math.round(PI)); // 3 to round values to the nearest number

console.log(Math.round(9.81)); // 10

console.log(Math.floor(PI)); // 3 rounding down

console.log(Math.ceil(PI)); // 4 rounding up

console.log(Math.min(-5, 3, 20, 4, 5, 10)); // -5, returns the minimum value

console.log(Math.max(-5, 3, 20, 4, 5, 10)); // 20, returns the maximum value

const randNum = Math.random(); // creates random number between 0 to 0.999999
console.log(randNum);

// Let us  create random number between 0 to 10

const num = Math.floor(Math.random() * 11); // creates random number between 0 and 10
console.log(num);

//Absolute value
console.log(Math.abs(-10)); // 10

//Square root
console.log(Math.sqrt(100)); // 10

console.log(Math.sqrt(2)); // 1.4142135623730951

// Power
console.log(Math.pow(3, 2)); // 9

console.log(Math.E); // 2.718

// Logarithm
// Returns the natural logarithm with base E of x, Math.log(x)
console.log(Math.log(2)); // 0.6931471805599453
console.log(Math.log(10)); // 2.302585092994046

// Returns the natural logarithm of 2 and 10 respectively
console.log(Math.LN2); // 0.6931471805599453
console.log(Math.LN10); // 2.302585092994046

// Trigonometry
Math.sin(0);
Math.sin(60);

Math.cos(0);
Math.cos(60);
```

### Checking data types and casting

- Check data type

```javascript
console.log(typeof "Asabeneh");
```

- Type casting
  - String to Int: `parseInt()`, `Number()`, `+`
  - String to Float: `parseFloat()`, `Number()`, `+`
  - Float to Int: `parseInt()`

## Conditional

### If

### If else

```javascript
// syntax
if (condition) {
  // this part of code runs for truthy condition
} else {
  // this part of code runs for false condition
}
```

### If else if else

```javascript
// syntax
if (condition) {
  // code
} else if (condition) {
  // code
} else {
  //  code
}
```

### switch

```javascript
let weather = "cloudy";
switch (weather) {
  case "rainy":
    console.log("You need a rain coat.");
    break;
  case "cloudy":
    console.log("It might be cold, you need a jacket.");
    break;
  case "sunny":
    console.log("Go out freely.");
    break;
  default:
    console.log(" No need for rain coat.");
}
```

### ternary operator

```javascript
let isRaining = true;
isRaining
  ? console.log("You need a rain coat.")
  : console.log("No need for a rain coat.");
```

## Loops

### for loop

```javascript
for (let i = 0; i < 6; i++) {
  console.log(i);
}
```

### while

```javascript
let count = prompt("Enter a positive number: ");
while (count > 0) {
  console.log(count);
  count--;
}
```

### for of (useful if not care about array index)

```javascript
const countries = ["Finland", "Sweden", "Norway", "Denmark", "Iceland"];
for (const country of countries) {
  console.log(country.toUpperCase());
}
```

### forEach (useful for loop over array with index)

```javascript
const numbers = [1, 2, 3, 4, 5]
numbers.forEach((number, i) => {
  console.log(number, i)
})
```

### for in (loop over object)

```javascript
const user = {
  firstName: 'Asabeneh',
  lastName: 'Yetayeh',
  age: 250,
  country: 'Finland',
  skills: ['HTML', 'CSS', 'JS', 'React', 'Node', 'Python', 'D3.js'],
}

for (const key in user) {
  console.log(key, user[key])
}
```

## Scope

- Window scope
- Global scope
- Local scope


## Object