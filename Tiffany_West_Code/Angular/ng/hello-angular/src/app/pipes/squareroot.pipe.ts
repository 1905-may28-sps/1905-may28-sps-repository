import { Pipe, PipeTransform } from '@angular/core';
import { namespaceMathML } from '@angular/core/src/render3';

@Pipe({
  name: 'squareroot'
})
export class SquarerootPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    return Math.sqrt(value);
  }


}
