const getTextFromRow = (row) => {
    return Array.from(row.getElementsByTagName("td")).map(td => td.textContent.toLowerCase());
};

const filterTable = () => {
    const noResultsRow = document.getElementById("no-results-row");
    noResultsRow.classList.add('d-none');

    const input = document.getElementById("search-box");
    const filterValue = input.value.toLowerCase();
    const rows = document.querySelectorAll("table > tbody > tr:not(#no-results-row)");

    rows.forEach(row => {
        const [nameColumnValue, typeColumnValue, dateColumnValue] = getTextFromRow(row);

        const matchesFilter = [nameColumnValue, typeColumnValue, dateColumnValue]
            .some(columnValue => columnValue.includes(filterValue));

        row.classList.toggle('d-none', !matchesFilter);
    });

    const hiddenRows = document.querySelectorAll("table > tbody > tr.d-none:not(#no-results-row)");

    if (hiddenRows.length === rows.length) {
        noResultsRow.classList.remove('d-none');
    }

};
