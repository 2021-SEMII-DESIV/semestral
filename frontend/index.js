(() => {
    const studentsContainer = document.querySelector('.page-content');
    const getStudents = async (event) => {
        const studentsRaw = await fetch('http://localhost:4567/estudiantes');
        const { group } = await studentsRaw.json();
        group.forEach(({ name, gradesAverage }) => {
            const template = `<div class="page-content-element"><span class="page-content-element-name">${name}</span><span class="page-content-element-average">${Math.round(gradesAverage)}</span></div>`
            studentsContainer.innerHTML += template;
        });
    };
    window.addEventListener('load', getStudents);
})();