import psa

#definição agente prospector
from agente_prospector import AgenteProspector

#def de controlo reativo
from controlo_react.controlo_react import ControloReact
from controlo_react.reaccoes.explorar import Explorar 
from controlo_react.reaccoes.evitar import Evitar
from controlo_react.reaccoes.recolher import Recolher

#def do comportamento
from ecr.comportamento import Comportamento

Comportamento = Recolher

#ativar
psa.iniciar("amb/amb1.das")

#executar agente
controlo = ControloReact(Comportamento())
agente = AgenteProspector(controlo)
psa.executar(agente)
