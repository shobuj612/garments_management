import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SewingTableComponent } from './sewing-table.component';

describe('SewingTableComponent', () => {
  let component: SewingTableComponent;
  let fixture: ComponentFixture<SewingTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SewingTableComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SewingTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
