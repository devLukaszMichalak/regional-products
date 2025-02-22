const getCsrfToken = () =>
    document.querySelector('meta[name="csrf-token"]').getAttribute('content');

const postRating = (productId, rating) =>
    fetch('/rating', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': getCsrfToken(),
        },
        body: JSON.stringify({productId, rating}),
    })
        .then(response => {
            if (response.redirected) {
                window.location.replace(response.url);
            } else if (response.status === 200) {
                window.location.reload();
            }
        })
        .catch(error => {
            console.error('Error submitting rating: ', error);
        });
