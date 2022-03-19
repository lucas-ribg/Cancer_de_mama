import { Component, OnInit } from '@angular/core';
import { Faixaetaria } from '../model/faixaetaria';
import { Ocorrencia } from '../model/ocorrencia';
import { Regiao } from '../model/regiao';
import { FaixaetariaService } from '../service/faixaetaria.service';
import { OcorrenciaService } from '../service/ocorrencia.service';
import { RegiaoService } from '../service/regiao.service';


@Component({
  selector: 'app-ocorrencias',
  templateUrl: './ocorrencias.component.html',
  styleUrls: ['./ocorrencias.component.scss']
})

export class OcorrenciasComponent implements OnInit {

  ocorrencia: Ocorrencia[] = [];
  regioes: Regiao[] = [];
  faixaetarias: Faixaetaria[] = [];

  constructor(
    private ocorrenciaService: OcorrenciaService,
    private regioesService: RegiaoService,
    private faixaEtariaService: FaixaetariaService
  ) { }

  ngOnInit(): void {
    this.regioesService.listRegioes().subscribe(regioes => {this.regioes = regioes});
    this.ocorrenciaService.listOcorrencias().subscribe(ocorrencia => {this.ocorrencia = ocorrencia});
    this.faixaEtariaService.listFaixaEtaria().subscribe(faixaetarias => {this.faixaetarias = faixaetarias});
    }
}
