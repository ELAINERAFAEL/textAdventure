document.getElementById('send-button').addEventListener('click', function() {
    const input = document.getElementById('command-input');
    const command = input.value.trim();

    if (command) {
        const gameText = document.getElementById('game-text');
        gameText.innerHTML += `<p><strong>Você:</strong> ${command}</p>`;

        input.value = '';

        gameText.innerHTML += `<p><strong>Jogo:</strong> Comando recebido: ${command}</p>`;
        gameText.scrollTop = gameText.scrollHeight;
    }
});
