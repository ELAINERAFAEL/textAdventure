document.getElementById('send-button').addEventListener('click', function() {
    const input = document.getElementById('command-input');
    const command = input.value.trim();

    if (command) {
        const gameText = document.getElementById('game-text');
        gameText.innerHTML += `<p><strong>Você:</strong> ${command}</p>`;

        // Limpa o campo de input
        input.value = '';

        // Faz a requisição para o servidor
        fetch(`/comando?comando=${encodeURIComponent(command)}`)
            .then(response => response.text())
            .then(data => {
                gameText.innerHTML += `<p><strong>Jogo:</strong> ${data}</p>`;
                gameText.scrollTop = gameText.scrollHeight; // Rolagem automática
            })
            .catch(error => {
                console.error('Erro:', error);
                gameText.innerHTML += `<p><strong>Jogo:</strong> Ocorreu um erro ao processar o comando.</p>`;
                gameText.scrollTop = gameText.scrollHeight;
            });
    }
});
