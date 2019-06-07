window.onload = function () {
    $('#liquor').on('click', 'li', function () {
        $('#drink').append(this);})
    $('#juice').on('click', 'li', function () {
        $('#drink').append(this);})
    $('#soda').on('click', 'li', function () {
        $('#drink').append(this);})
    $('#type').on('click', 'li', function () {
        $('#drink').append(this);})
}
