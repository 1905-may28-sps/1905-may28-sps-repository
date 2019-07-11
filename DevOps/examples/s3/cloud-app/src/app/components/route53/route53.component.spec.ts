import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Route53Component } from './route53.component';

describe('Route53Component', () => {
  let component: Route53Component;
  let fixture: ComponentFixture<Route53Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Route53Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Route53Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
