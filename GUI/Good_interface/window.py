import webview


# 1. CLASSE API - Métodos que o JavaScript poderá chamar
class Api:
    def __init__(self):
        self._window = None

    def set_window(self, window):
        self._window = window

    def criar_novo_relatorio(self):
        print("[PYTHON] Solicitado novo relatório pelo usuário!")
        # Retorna uma mensagem de resposta para o JavaScript
        return "Relatório gerado com sucesso às 14:30!"

    def navegar_para(self, menu_nome):
        print(f"[PYTHON] Navegando para a seção: {menu_nome}")
        return f"Conteúdo da página '{menu_nome}' carregado."


# 2. HTML + CSS (Tailwind) + JavaScript de Integração
HTML_CONTENT = """
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://cdn.tailwindcss.com"></script>
  <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
  <style>
    body { font-family: 'Inter', sans-serif; }
    .glass {
      background: rgba(30, 41, 59, 0.7);
      backdrop-filter: blur(12px);
      -webkit-backdrop-filter: blur(12px);
      border: 1px solid rgba(255, 255, 255, 0.08);
    }
  </style>
</head>
<body class="bg-[#0B0F19] text-slate-200 h-screen flex overflow-hidden select-none">

  <!-- SIDEBAR MINIMALISTA -->
  <aside class="w-64 bg-[#111827] border-r border-slate-800/80 p-6 flex flex-col justify-between">
    <div>
      <div class="flex items-center gap-3 mb-10">
        <div class="w-9 h-9 bg-indigo-600 rounded-xl flex items-center justify-center text-white shadow-lg shadow-indigo-500/30 font-bold">
          ⚡
        </div>
        <span class="text-xl font-bold tracking-wider text-white">NEXUS</span>
      </div>

      <nav class="space-y-2">
        <button onclick="navegar('Overview')" class="w-full flex items-center gap-3 px-4 py-3 rounded-xl bg-indigo-600/10 text-indigo-400 font-medium text-sm transition-all hover:bg-indigo-600/20">
          <span>📊</span> Overview
        </button>
        <button onclick="navegar('Analytics')" class="w-full flex items-center gap-3 px-4 py-3 rounded-xl text-slate-400 hover:bg-slate-800/60 hover:text-slate-200 font-medium text-sm transition-all">
          <span>📈</span> Analytics
        </button>
        <button onclick="navegar('Projetos')" class="w-full flex items-center gap-3 px-4 py-3 rounded-xl text-slate-400 hover:bg-slate-800/60 hover:text-slate-200 font-medium text-sm transition-all">
          <span>📁</span> Projetos
        </button>
        <button onclick="navegar('Configurações')" class="w-full flex items-center gap-3 px-4 py-3 rounded-xl text-slate-400 hover:bg-slate-800/60 hover:text-slate-200 font-medium text-sm transition-all">
          <span>⚙️</span> Configurações
        </button>
      </nav>
    </div>

    <div class="flex items-center gap-3 p-3 rounded-xl bg-slate-800/40 border border-slate-800">
      <div class="w-8 h-8 rounded-full bg-indigo-500 text-white flex items-center justify-center font-bold text-xs">
        JS
      </div>
      <div>
        <p class="text-sm font-semibold text-white leading-none">João Silva</p>
        <p class="text-xs text-slate-400 mt-1">Admin</p>
      </div>
    </div>
  </aside>

  <!-- ÁREA DE CONTEÚDO PRINCIPAL -->
  <main class="flex-1 p-8 overflow-y-auto">
    <header class="flex justify-between items-center mb-8">
      <div>
        <h1 id="titulo-pagina" class="text-2xl font-bold text-white">Visão Geral</h1>
        <p class="text-sm text-slate-400 mt-1">Acompanhe as métricas do sistema em tempo real</p>
      </div>

      <!-- BOTÃO QUE CHAMA O PYTHON -->
      <button onclick="gerarRelatorio()" class="px-5 py-2.5 bg-indigo-600 hover:bg-indigo-500 active:scale-95 text-white font-medium text-sm rounded-xl shadow-lg shadow-indigo-600/30 transition-all">
        + Novo Relatório
      </button>
    </header>

    <!-- ÁREA DE NOTIFICAÇÃO/STATUS -->
    <div id="status-box" class="hidden mb-6 p-4 rounded-xl bg-indigo-500/10 border border-indigo-500/30 text-indigo-300 text-sm">
    </div>

    <!-- CARDS DE MÉTRICAS -->
    <div class="grid grid-cols-3 gap-6 mb-8">
      <div class="glass p-6 rounded-2xl">
        <p class="text-xs font-medium text-slate-400 uppercase tracking-wider">Receita Total</p>
        <div class="flex justify-between items-baseline mt-4">
          <span class="text-3xl font-bold text-white">R$ 148.200</span>
          <span class="text-xs font-semibold text-emerald-400 bg-emerald-500/10 px-2.5 py-1 rounded-full">+12.4%</span>
        </div>
      </div>
      <div class="glass p-6 rounded-2xl">
        <p class="text-xs font-medium text-slate-400 uppercase tracking-wider">Usuários Ativos</p>
        <div class="flex justify-between items-baseline mt-4">
          <span class="text-3xl font-bold text-white">24.521</span>
          <span class="text-xs font-semibold text-emerald-400 bg-emerald-500/10 px-2.5 py-1 rounded-full">+8.1%</span>
        </div>
      </div>
      <div class="glass p-6 rounded-2xl">
        <p class="text-xs font-medium text-slate-400 uppercase tracking-wider">Taxa de Churn</p>
        <div class="flex justify-between items-baseline mt-4">
          <span class="text-3xl font-bold text-white">1.2%</span>
          <span class="text-xs font-semibold text-rose-400 bg-rose-500/10 px-2.5 py-1 rounded-full">-0.4%</span>
        </div>
      </div>
    </div>
  </main>

  <!-- JAVASCRIPT QUE COMUNICA COM O PYTHON -->
  <script>
    // Chama a função Python 'criar_novo_relatorio' via pywebview.api
    async function gerarRelatorio() {
      if (window.pywebview && window.pywebview.api) {
        const resposta = await window.pywebview.api.criar_novo_relatorio();
        exibirStatus(resposta);
      }
    }

    // Chama a função Python 'navegar_para'
    async function navegar(pagina) {
      if (window.pywebview && window.pywebview.api) {
        document.getElementById('titulo-pagina').innerText = pagina;
        const resposta = await window.pywebview.api.navegar_para(pagina);
        exibirStatus(resposta);
      }
    }

    function exibirStatus(mensagem) {
      const box = document.getElementById('status-box');
      box.innerText = mensagem;
      box.classList.remove('hidden');
      setTimeout(() => { box.classList.add('hidden'); }, 4000);
    }
  </script>

</body>
</html>
"""

if __name__ == "__main__":
    api = Api()
    window = webview.create_window(
        title="Nexus OS — Control Center",
        html=HTML_CONTENT,
        width=1100,
        height=720,
        js_api=api,
        resizable=True
    )
    api.set_window(window)
    webview.start()