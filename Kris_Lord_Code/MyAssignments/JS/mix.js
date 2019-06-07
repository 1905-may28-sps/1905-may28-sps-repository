window.onload = function () {
    $('#liquor').on('click', 'li', function () {
        $('.drink').append(this);})
    $('#juice').on('click', 'li', function () {
        $('.drink').append(this);})
    $('#soda').on('click', 'li', function () {
        $('.drink').append(this);})
    $('#type').on('click', 'li', function () {
        $('.drink').append(this);})
//     var count = 1;
//     $('#new').on('dblclick', function() {
//     $(this).after("<tr><th scope='row'>" + (++count) + "</th><td><ul id='liquor'><li>Rum</li><li>Whiskey</li><li>Tequila</li><li>Cognac</li><li>Vodka</li></ul></td><td><ul id='juice'><li>orange</li><li>pineapple</li><li>cranberry</li><li>lemonade</li></ul></td><td><ul id='soda'><li>sprite</li><li>coke</li><li>ginger ale</li><li>seltzer</li></ul></td><td><ul id='type'><li>shaken</li><li>on the rocks</li><li>frozen</li><li>stirred</li><li>popscicles</li><li>jello</li></ul></td><td><ul class='drink'></ul></td><td><ul><li>cost</li><li><button class='btn-primary btn' id='order'>Order</button></li></ul></td></tr>");
// });
}
