import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FabricTableComponent } from './fabric-table.component';

describe('FabricTableComponent', () => {
  let component: FabricTableComponent;
  let fixture: ComponentFixture<FabricTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FabricTableComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FabricTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
