import psa
from psa.agente import Agente
from psa.accao import Avancar
from agente_prospector import AgenteProspector

from controlo_delib.controlo_delib import ControloDelib
from plan.plan_pee.plan_pee import PlanPEE
from plan.plan_pdm.plan_pdm import PlanPDM
from pee.melhorprim.procura_aa import ProcuraAA
from pee.melhorprim.procura_sofrega import ProcuraSofrega
from pee.melhorprim.procura_melhor_prim import ProcuraMelhorPrim

psa.iniciar("amb/amb2.das")

plan = PlanPDM()
controlo = ControloDelib(plan)
agente = AgenteProspector(controlo)

psa.executar(agente)