document.addEventListener('DOMContentLoaded', () => {
    const form = document.querySelector('form');

    form.addEventListener('submit', (event) => {
        event.preventDefault(); // Prevent the default form submission

        const course = document.getElementById('course').value;
        const examDate = document.getElementById('examDate').value;
        const examDuration = document.getElementById('examDuration').value;
        const examType = document.getElementById('examType').value;

        // Basic validation
        if (!course || !examDate || !examDuration || !examType) {
            alert('Please fill in all fields before submitting.');
            return;
        }

        // Display a confirmation message
        alert(`Examination Scheduled Successfully:\n\nCourse: ${course}\nDate: ${examDate}\nDuration: ${examDuration} hours\nType: ${examType}`);

        // Reset the form after submission
        form.reset();
    });
});
