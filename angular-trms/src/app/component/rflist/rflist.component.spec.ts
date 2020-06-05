import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RflistComponent } from './rflist.component';

describe('RflistComponent', () => {
  let component: RflistComponent;
  let fixture: ComponentFixture<RflistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RflistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RflistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
