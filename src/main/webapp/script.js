let csvData = [];

document.addEventListener('DOMContentLoaded', loadCSV);
document.getElementById('filterButton').addEventListener('click', filterData);

function loadCSV() {
    Papa.parse('data.csv', {
        download: true,
        header: true,
        dynamicTyping: true,
        complete: function(results) {
            csvData = results.data;
            console.log(csvData); // For debugging
        }
    });
}

function filterData() {
    const genreInput = document.getElementById('genreInput').value.toLowerCase();
    const filteredData = csvData.filter(row => row.Genre && row.Genre.toLowerCase().includes(genreInput));
    displayData(filteredData);
}

function displayData(data) {
    const csvDataDiv = document.getElementById('csvData');
    csvDataDiv.innerHTML = '';

    if (data.length === 0) {
        csvDataDiv.innerHTML = '<p>No data available for the selected genre</p>';
        return;
    }

    const table = document.createElement('table');
    const headerRow = document.createElement('tr');

    // Create header row
    const headers = Object.keys(data[0]);
    headers.forEach(header => {
        const th = document.createElement('th');
        th.textContent = header;
        headerRow.appendChild(th);
    });
    table.appendChild(headerRow);

    // Create data rows
    data.forEach(row => {
        const tr = document.createElement('tr');
        headers.forEach(header => {
            const td = document.createElement('td');
            td.textContent = row[header];
            tr.appendChild(td);
        });
        table.appendChild(tr);
    });

    csvDataDiv.appendChild(table);
}