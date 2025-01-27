document.addEventListener("DOMContentLoaded", function() {
    const courseSelect = document.getElementById("courseSelect");

    courseSelect.addEventListener("change", function() {
        const selectedCourse = courseSelect.value;
        alert(`You selected: ${selectedCourse}`);
    });
});
