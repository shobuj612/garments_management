import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MarchendiserOrderlistComponent } from './marchendiser-orderlist.component';

describe('MarchendiserOrderlistComponent', () => {
  let component: MarchendiserOrderlistComponent;
  let fixture: ComponentFixture<MarchendiserOrderlistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MarchendiserOrderlistComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MarchendiserOrderlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
