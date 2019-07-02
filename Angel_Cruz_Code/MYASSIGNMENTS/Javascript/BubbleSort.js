// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.

function bubbleSort(array) {
    var newArr = array.split(', ');
    var newArr2 = newArr.map(Number);

    var swapped;
    do {
        swapped = false;
        for (var i=0; i < newArr2.length-1; i++) {
            if (newArr2[i] > newArr2[i+1]) {
                var temp = newArr2[i];
                newArr2[i] = newArr2[i+1];
                newArr2[i+1] = temp;
                swapped = true;
            }
        }
    }
    while (swapped);
    document.getElementById("output").innerHTML=newArr2;
    return;
}