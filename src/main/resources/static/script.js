
const dropArea = document.getElementById('drop-area');
const fileInput = document.getElementById('file');
const dragText = document.getElementById('browse-text');

// Prevent default drag behaviors
['dragenter', 'dragover', 'dragleave', 'drop'].forEach(eventName => {
    dropArea.addEventListener(eventName, preventDefaults, false);
    document.body.addEventListener(eventName, preventDefaults, false);
});

// Highlight drop area when dragging file over it
['dragenter', 'dragover'].forEach(eventName => {
    dropArea.addEventListener(eventName, highlight, false);
});

['dragleave', 'drop'].forEach(eventName => {
    dropArea.addEventListener(eventName, unhighlight, false);
});

// Handle dropped files
dropArea.addEventListener('drop', handleDrop, false);

function preventDefaults(e) {
    e.preventDefault();
    e.stopPropagation();
}

function highlight() {
    dropArea.classList.add('highlight');
    dragText.style.display = 'block';
}

function unhighlight() {
    dropArea.classList.remove('highlight');    
    dragText.style.display = 'block';
    
}

function handleDrop(e) {
    const dt = e.dataTransfer;
    const files = dt.files;

    handleFiles(files);
}

function handleFiles(files,fileName) {
    if (files.length > 0) {
        const file = files[0];
        fileInput.files = files;
        fileName = file.name       
        console.log('File selected:',fileName);
        dragText.textContent=fileName;
         
    }
}

// Clicking the drop area triggers file input click
dropArea.addEventListener('click', (files,fileName) => {
    fileInput.click();
    handleFiles(files,fileName)
});

