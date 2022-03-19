import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatSortModule } from '@angular/material/sort';
import { HttpClientModule } from '@angular/common/http';

import { OcorrenciasRoutingModule } from './ocorrencias-routing.module';
import { OcorrenciasComponent } from './ocorrencias/ocorrencias.component';
import { OcorrenciaService } from './service/ocorrencia.service';



@NgModule({
  declarations: [
    OcorrenciasComponent
  ],
  imports: [
    CommonModule,
    OcorrenciasRoutingModule,
    MatSortModule,
    MatCardModule,
    HttpClientModule
  ],
  providers: [
    OcorrenciaService
  ]
})
export class OcorrenciasModule { }
