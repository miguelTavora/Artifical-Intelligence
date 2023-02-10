import psa
from psa.agente import Agente
from psa.accao import Avancar

from plan.plan_pee.plan_pee import PlanPEE

from agente_prospector import AgenteProspector
from controlo_delib.controlo_delib import ControloDelib 

from pee.melhorprim.procura_aa import ProcuraAA
from pee.melhorprim.procura_melhor_prim import ProcuraMelhorPrim
from pee.melhorprim.procura_sofrega import ProcuraSofrega


mec_pee = ProcuraSofrega()#ProcuraAA
plan = PlanPEE(mec_pee)
controlo = ControloDelib(plan)
agente = AgenteProspector(controlo)

#iniciar plataforma
psa.iniciar("amb/amb1.das")

#executar o agente
psa.executar(agente)

'''import os

print(os.path.abspath(os.path.curdir))
print(os.environ['PYTHONPATH'])'''
