(() => {
    async function postData(url = '', data = {}) {
        // Default options are marked with *
        const response = await fetch(url, {
            method: 'POST', // *GET, POST, PUT, DELETE, etc.
            mode: 'cors', // no-cors, *cors, same-origin
            cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
            credentials: 'same-origin', // include, *same-origin, omit
            headers: {
            'Content-Type': 'application/json'
            // 'Content-Type': 'application/x-www-form-urlencoded',
            },
            redirect: 'follow', // manual, *follow, error
            referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
            body: JSON.stringify(data) // body data type must match "Content-Type" header
        });
        return response.json(); // parses JSON response into native JavaScript objects
    }


    const createStudentForm = document.getElementById('createStudent');
    const createStudentFormHandler = async (event) => {
        event.preventDefault();
        const name = document.querySelector("#createStudent input[name='name']").value;
        const gradesInputs = document.querySelectorAll("#createStudent input[name='grades[]']");
        const grades = [];
        gradesInputs.forEach(g => {
            grades.push(parseInt(g.value));
        });
        try {
            await postData('http://localhost:4567/estudiantes', { name, grades });            
            alert('Agregado el estudiante correctamente.');
            window.location.href = "/frontend/index.html";
        } catch (error) {            
            alert('Error en la petición.');
        }        
    };
    createStudentForm.addEventListener('submit', createStudentFormHandler);
})();