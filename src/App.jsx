import CardCentral from "./components/CardCentral";
import CardDer from "./components/CardDer";
import CardIzq from "./components/CardIzq";
import Bloquecuatro from "./components/Bloquecuatro";
import Bloquetres from "./components/Bloquetres";
import Linesecondary from "./components/Linesecondary";
import Secondarysection from "./components/Secondarysection";
import Lineprimary from "./components/Lineprimary";
import Header from "./components/Header";
import Primarysection from "./components/Primarysection";

function App() {
  return (
    <div className="">
      <Header />
      <Primarysection />
      <Lineprimary />
      <Secondarysection />
      <Linesecondary />
      <Bloquetres />
      <Bloquecuatro />
      <div className="grid grid-cols-1 md:grid-cols-3">
      <div>
      <CardIzq />
      <CardIzq />
      <CardIzq />
      <CardIzq />
      </div>
      <CardCentral />
      <div>
      <CardDer />
      <CardDer />
      <CardDer />
      <CardDer />
      </div>
      </div>
    </div>
  );
}

export default App;
