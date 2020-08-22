let strArr1 = ["Ashish","Rishav","Arjun","Jimmy"]
let strArr2 = ["Banana","Apple","Peach","Litchi","Apple"]
var numbers = [175, 50, 25];

//The results are mentioned below the command in comments
//Array Methods

console.log(strArr1.concat(strArr2))
// [
//     'Ashish', 'Rishav',
//     'Arjun',  'Jimmy',
//     'Banana', 'Apple',
//     'Peach',  'Litchi',
//     'Apple'
//   ]

console.log(strArr2.every((value) => {return value.length > 3}))
// true

console.log(strArr2.filter((value) => {return value.length > 5}))
// [ 'Banana', 'Litchi' ]

strArr2.forEach((value) => {console.log(value)})
// Banana
// Apple
// Peach
// Litchi
// Apple

console.log(strArr2.indexOf("Apple"))
// 1

console.log(strArr2.join())
// Banana,Apple,Peach,Litchi,Apple

console.log(strArr2.lastIndexOf("Apple"))
// 4

console.log(strArr2.map((value) => {return value+"Suffix"}))
// [
//     'BananaSuffix',
//     'AppleSuffix',
//     'PeachSuffix',
//     'LitchiSuffix',
//     'AppleSuffix'
//   ]

console.log(strArr2.toLocaleString())
// Apple,Banana,Lemon,Kiwi,Litchi,Peach,Strawberry

console.log(strArr2.pop())
// Apple

strArr2.push("Strawberry")
console.log(strArr2)
// [ 'Banana', 'Apple', 'Peach', 'Litchi', 'Strawberry' ]


console.log(numbers.reduce((total,num) => { return total-num}))
// 100

console.log(numbers.reduceRight((total,num) => {return total-num}))
// -200

console.log(numbers.reverse())
// [ 25, 50, 175 ]

numbers.shift()
console.log(numbers)
// [ 50, 175 ]

numbers.unshift(25)
console.log(numbers)
// [ 25, 50, 175 ]


console.log(numbers.slice(0,2))
// [ 25, 50 ]

console.log(numbers.some((value) => {return value > 30}))
// true

console.log(strArr2.sort())
// [ 'Apple', 'Banana', 'Litchi', 'Peach', 'Strawberry' ]

strArr2.splice(2, 0, "Lemon", "Kiwi");
console.log(strArr2)
// [ 'Apple', 'Banana', 'Lemon', 'Kiwi', 'Litchi', 'Peach', 'Strawberry' ]

console.log(strArr2.toString())
// Apple,Banana,Lemon,Kiwi,Litchi,Peach,Strawberry



//Regex Methods

var testStr = "Javascript is the best language ever"
var pattern1 = new RegExp("is")
console.log(pattern1.exec(testStr))
// [
//     'is',
//     index: 11,
//     input: 'Javascript is the best language ever',
//     groups: undefined
//   ]

console.log(pattern1.test(testStr))
// true

console.log(testStr.match(/is/))
// [
//     'is',
//     index: 11,
//     input: 'Javascript is the best language ever',
//     groups: undefined
//   ]

console.log(testStr.search("iso"))
// -1

console.log(testStr.replace("is","replace"))
// Javascript replace the best language ever

console.log(testStr.split(" "))
// [ 'Javascript', 'is', 'the', 'best', 'language', 'ever' ]
