document.addEventListener('DOMContentLoaded', () => {
    const searchButton = document.getElementById('search-button');
    const regionSearch = document.getElementById('region-search');
    const posts = document.querySelectorAll('.post');

    searchButton.addEventListener('click', () => {
        const searchValue = regionSearch.value.trim().toLowerCase();

        posts.forEach(post => {
            const region = post.getAttribute('data-region').toLowerCase();
            if (region.includes(searchValue) || searchValue === '') {
                post.style.display = 'flex';
            } else {
                post.style.display = 'none';
            }
        });
    });
});