// script.js

document.getElementById('facultyForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const facultyName = document.getElementById('facultyName').value;
    const department = document.getElementById('department').value;
    const email = document.getElementById('email').value;
    const phone = document.getElementById('phone').value;

    // Simple form validation (example)
    if (facultyName && department && email && phone) {
        alert('Faculty added successfully!');
        // You can add functionality to submit data to a server or save in local storage
    } else {
        alert('Please fill in all fields.');
    }

    // Optionally, clear form after submission
    document.getElementById('facultyForm').reset();
});
