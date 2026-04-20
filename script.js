const API_URL = "https://didactic-space-waffle-jgp57549pr5f9qq-8080.app.github.dev/gastos";

async function cadastrarGasto() {
    const descricao = document.getElementById("nomeGasto").value;
    const valor = document.getElementById("valorGasto").value;

    const response = await fetch(API_URL, {method: "POST",
        headers: {
        "Content-Type": "application/json"
    },
        body: JSON.stringify({
            descricao: descricao,
            valor: Number(valor)
            //a esquerda = nomes dos campos que estou enviando pro backend//
            //a direita = valores vindos do input via JS//
        })
    });

    const data = await response.json();
    console.log("Salvo:", data);

    listarGastos(); //atualiza a lista //
}

async function listarGastos() {
    const response = await fetch(API_URL);
    const gastos = await response.json();

    const lista =
    document.getElementById("listaGastos");
    lista.innerHTML = "";

    gastos.forEach(gasto => {
        const item = document.createElement("li");
        item.textContent = `${gasto.descricao} - R$ ${gasto.valor}`;
        lista.appendChild(item);
    });
}

window.onload = listarGastos;
//chama a funcao listarGastos assim que a pagina terminar de carregar//