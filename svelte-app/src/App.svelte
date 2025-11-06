<script>
	import Hijo from './Hijo.svelte';
	export let name;
	let nombre;


	let contador = 0;
	function incrementar(){
		contador = contador + 1;
	}

	function saludar(){
		alert(nombre ? nombre : "nulo")
	}
</script>

<main>
	<p>Adios {name}!</p>
	<h1>Contar: {contador}</h1>
	<button on:click={incrementar}>Contar++</button>

	<button on:click={saludar}>Saludar</button>
	<input bind:value={nombre} placeholder="Tu nombre">

	<Hijo color="red" texto="Guardar"></Hijo>
	<Hijo texto="Borrar"></Hijo>

</main>

<style>
	main {
		text-align: center;
		padding: 1em;
		max-width: 240px;
		margin: 0 auto;
	}

	h1 {
		color: #ff3e00;
		text-transform: uppercase;
		font-size: 4em;
		font-weight: 100;
	}

	@media (min-width: 640px) {
		main {
			max-width: none;
		}
	}
</style>