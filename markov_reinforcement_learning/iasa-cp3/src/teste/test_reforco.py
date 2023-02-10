import psa

from controlo_aprend.controlo_aprend_ref import ControloAprendRef
from agente_prospector import AgenteProspector

controlo = ControloAprendRef()
agente = AgenteProspector(controlo)

#iniciar plataforma
psa.iniciar("amb/amb3.das", reiniciar=True)


#executar o agente
psa.executar(agente)