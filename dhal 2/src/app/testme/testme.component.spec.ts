import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TestmeComponent } from './testme.component';

describe('TestmeComponent', () => {
  let component: TestmeComponent;
  let fixture: ComponentFixture<TestmeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TestmeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TestmeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
